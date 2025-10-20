import 'package:go_router/go_router.dart';
import 'package:task_manager_flutter/screens/auth/guard_Screen.dart';

final router = GoRouter(
  routes: <RouteBase> [
    GoRoute(
      path: "/",
      builder: (context, state) => GuardScreen(),
    ),
  ]
);
