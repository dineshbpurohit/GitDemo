package stepDefinations;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Assert;


@SuppressWarnings("deprecation")
public class script {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Query
		int characterId=14;
		String  response = given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"query\": \"query($characterId:Int!,$episodeId:Int!)\\n{\\n character(characterId: $characterId)\\n  {\\n   name\\n    type\\n    status\\n    \\n  }\\n  characters(filters: {name:\\\"Rahul\\\"})\\n {\\n  info\\n  {\\n    count\\n  }\\n  result\\n  {\\n    id\\n    name\\n    type\\n  }\\n }\\n  episodes(filters: {episode: \\\"hulu\\\"})\\n  {\\n    result\\n    {\\n     id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n  \\n  episode(episodeId:$episodeId)\\n  {\\n    name\\n    air_date\\n    episode\\n  }\\n  \\n}\\n\",\r\n"
				+ "    \"variables\": {\r\n"
				+ "        \"characterId\": "+characterId+",\r\n"
				+ "        \"episodeId\": 1\r\n"
				+ "    }\r\n"
				+ "}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String characterName = js.getString("data.character.name");
		Assert.assertEquals(characterName, "Robin");
		
		
		//Mutation
		String newcharacterName="Baskin Robin";
		String  mutationresponse = given().log().all().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"query\": \"mutation($locationName:String!,$characterName:String!,$episodeName:String!) {\\n  createLocation(location: {name: $locationName, type: \\\"South\\\", dimension: \\\"234\\\"}) {\\n    id\\n  }\\n   createCharacter(character:{name:$characterName,status:\\\"dead\\\",type:\\\"Macho\\\",species:\\\"fantacy\\\",gender:\\\"male\\\",image:\\\"png\\\",originId:489,locationId:489})\\n{\\n    id\\n  }\\n  createEpisode(episode:{name:$episodeName,air_date:\\\"1950 June\\\",episode:\\\"prime\\\"})\\n  {\\n    id\\n  }\\n  deleteLocations(locationIds:[483,484])\\n  {\\n    locationsDeleted\\n  }\\n}\\n\",\r\n"
						+ "    \"variables\": {\r\n"
						+ "        \"locationName\": \"NewZealand\",\r\n"
						+ "        \"characterName\": \""+newcharacterName+"\",\r\n"
						+ "        \"episodeName\": \"Manifest\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().extract().response().asString();
				System.out.println(mutationresponse);
				JsonPath js1 = new JsonPath(mutationresponse);
		
	}

}
