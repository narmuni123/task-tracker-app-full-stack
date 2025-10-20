import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/user_model.dart';

class RegistrationRepository {
  final String baseUrl;

  RegistrationRepository({required this.baseUrl});

  Future<Map<String, dynamic>> registerUser(UserModel user) async {
    final url = Uri.parse('$baseUrl/api/v1/users/register');

    try {
      final response = await http.post(
        url,
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode(user.toJson()),
      );

      if (response.statusCode == 201) {
        return jsonDecode(response.body);
      } else if (response.statusCode >= 400 && response.statusCode < 500) {
        final body = response.body.isNotEmpty
            ? jsonDecode(response.body)
            : {'message': 'Client error occurred'};
        throw Exception(body['message'] ?? 'Client error occurred');
      } else if (response.statusCode >= 500) {
        throw Exception('Server error: Please try again later.');
      } else {
        throw Exception('Unexpected error: ${response.statusCode}');
      }
    } on http.ClientException catch (e) {
      throw Exception('Network error: ${e.message}');
    } on FormatException catch (_) {
      throw Exception('Bad response format from server.');
    } catch (e) {
      throw Exception('An unexpected error occurred: $e');
    }
  }
}
