package api.endpoint;

public class Routes {

	public static String baseUrl = "https://petstore.swagger.io/v2";

	// users
	public static String createUser = baseUrl + "/user";
	public static String getUser = baseUrl + "/user/{username}";
	public static String updateUser = baseUrl + "/user/{username}";
	public static String deleteUser = baseUrl + "/user/{username}";

}
