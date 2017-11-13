-- 初始化数据库表数结构和数据 --
insert into app_plugin_config (id, create_date, modify_date, orders, is_enabled, plugin_id) values(1, '${date?string("yyyy-MM-dd HH:mm:ss")}', '${date?string("yyyy-MM-dd HH:mm:ss")}', 100, ${bit1}, 'filePlugin')
