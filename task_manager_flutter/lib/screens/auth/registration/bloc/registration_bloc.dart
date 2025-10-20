import 'package:flutter_bloc/flutter_bloc.dart';
import '../../../../repository/registration_repository.dart';
import 'registration_event.dart';
import 'registration_state.dart';

class RegistrationBloc extends Bloc<RegistrationEvent, RegistrationState> {
  final RegistrationRepository repository;

  RegistrationBloc(this.repository) : super(RegistrationInitial()) {
    on<RegisterUserEvent>((event, emit) async {
      emit(RegistrationLoading());
      try {
        final data = await repository.registerUser(event.user);
        emit(
          RegistrationSuccess(
            message: data['message'] ?? 'Registered successfully!',
          ),
        );
      } catch (e) {
        emit(
          RegistrationFailure(
            error: e.toString().replaceAll('Exception: ', ''),
          ),
        );
      }
    });
  }
}
