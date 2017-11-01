package com.zzq.util;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.zzq.control.MainControl;
import com.zzq.entity.Anime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetAnime {
	
	MainControl mainControl;
	
	
	public GetAnime(MainControl mainControl){
		this.mainControl = mainControl;
	}
	
	
	public static void PostHtml(String url){
		
		try {
			//源数据为json格式，强制转为document文件，设置请求头伪装成浏览器，避免被发现
			Document doc = Jsoup.connect(url).header("Accept", "*/*")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.header("Referer", "https://www.baidu.com/")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
					.timeout(5000).ignoreContentType(true).get() ;
			//取到document文件的body内容，即json数据
			Element body = doc.body();
			JSONObject json = JSONObject.fromObject(body.text());
			JSONArray result = json.getJSONArray("result");
			int is_today;//判断是否为今天
			JSONArray animeList = null;
			
			//遍历result中的数据直到当天的数据
			for(int i=0;i<result.size();i++){
				JSONObject day_single =(JSONObject)result.get(i);
				is_today = day_single.getInt("is_today");
				if(1==is_today){
					animeList = (JSONArray)day_single.get("seasons");
					//将之前加入的Anime清空，重新加入
					MainControl.list.clear();
					
					//获取数据中的有用信息加到list中
					for(int j=0;j<animeList.size();j++){
						String time = animeList.getJSONObject(j).getString("pub_time"); 
						String name = animeList.getJSONObject(j).getString("title");
						String link = animeList.getJSONObject(j).getString("season_id");
						String image = animeList.getJSONObject(j).getString("square_cover");
						String count = animeList.getJSONObject(j).getString("pub_index");
						
						MainControl.list.add(new Anime(time, name, link, image, count));
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("GetAnime IOException");
		}
	}
}
