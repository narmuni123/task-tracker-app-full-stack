import 'package:equatable/equatable.dart';

abstract class RegistrationState extends Equatable {
  @override
  List<Object?> get props => [];
}

class RegistrationInitial extends RegistrationState {}

class RegistrationLoading extends RegistrationState {}

class RegistrationSuccess extends RegistrationState {
  final String message;

  RegistrationSuccess({required this.message});

  @override
  List<Object?> get props => [message];
}

class RegistrationFailure extends RegistrationState {
  final String error;

  RegistrationFailure({required this.error});

  @override
  List<Object?> get props => [error];
}
