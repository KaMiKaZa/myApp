INSERT INTO "cities" ("id", "name", "population") VALUES
(1, 'Bratislava', 432000),
(2, 'Budapest', 1759000),
(3, 'Prague', 1280000),
(4, 'Warsaw', 1748000),
(5, 'Los Angeles', 3971000),
(6, 'New York', 8550000),
(7, 'Edinburgh', 464000),
(8, 'Berlin', 3671000);


INSERT INTO "app_users" VALUES
(1, 'admin', '$2a$10$wbrRbN1dXLPYWevEJz/.7OCAoP.HSaonsPJIHDp2k6QQ79Yg.zq5.'),
(2, 'user', '$2a$10$BISj2JaLJeNfGpr0r5Jp3uj.1ILropQGqiFxXawDZpMlq4u8.xT92'),
(3, 'worker', '$2a$10$FwEfZXBCQsfNvP/nqr42guO3ROqWkJAkSgX3gm9yI7EQga8yBOZEi');


INSERT INTO "app_roles" VALUES
(1, 'ADMIN', 'Role for user [admin]'),
(2, 'USER', 'Role for user [user]'),
(3, 'WORKER', 'Role for user [worker]');


INSERT INTO "app_userRoles" VALUES
(1, 1),
(2, 2),
(3, 3);