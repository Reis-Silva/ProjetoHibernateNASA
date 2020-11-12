package webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;

import entity.nasa.Items;

public class WEBService {
	
	// Armazenando Dados na lista
		public static List<Items> listarDadosNASA() throws Exception {

			WEBService ws = new WEBService();
			String url = "https://images-api.nasa.gov/search?q=apollo%2011";
			
			if(ws.obterDadosNASA(url) == null) {
				return null;
			}else {
				String json = ws.obterDadosNASA(url);		
				Gson g = new Gson();
				GetCollection NASAReposit = new GetCollection();
				NASAReposit = g.fromJson(json, GetCollection.class);

				List<Items> dadosNASA = convertArrayToList(NASAReposit.getCollection().getItems());
				return dadosNASA;			
			}
		}
		
		public static List<Items> listarMediaNASA(String NASAID) throws Exception {

			WEBService ws = new WEBService();
			String url = " https://images-api.nasa.gov/asset/"+NASAID;
			
			if(ws.obterDadosNASA(url) == null) {
				return null;
			}else {
				String json = ws.obterDadosNASA(url);		
				Gson g = new Gson();
				GetCollection NASAReposit = new GetCollection();
				NASAReposit = g.fromJson(json, GetCollection.class);

				List<Items> dadosNASA = convertArrayToList(NASAReposit.getCollection().getItems());
				return dadosNASA;			
			}
		}
		
		// Obtendo dados da URL
		public String obterDadosNASA(String url) throws Exception {
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.getPermission();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
				return null;
			}else {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				StringBuffer response = new StringBuffer();
				String line;
				while ((line = br.readLine()) != null) {
					response.append(line);
				}	
				conn.disconnect();
				return response.toString();
			}	
		}

		// Conversão de Arrays
		public static <T> List<T> convertArrayToList(T array[]) {
			List<T> list = new ArrayList<>();
			for (T t : array) {
				list.add(t);
			}
			return list;
		}
	
}
