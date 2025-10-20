// lib/screens/registration/bloc/registration_event.dart
import 'package:equatable/equatable.dart';
import '../../../../models/user_model.dart';

abstract class RegistrationEvent extends Equatable {
  @override
  List<Object?> get props => [];
}

class RegisterUserEvent extends RegistrationEvent {
  final UserModel user;

  RegisterUserEvent(this.user);

  @override
  List<Object?> get props => [user];
}
