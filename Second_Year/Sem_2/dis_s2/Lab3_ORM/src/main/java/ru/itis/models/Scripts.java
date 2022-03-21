package ru.itis.models;

public class Scripts {
    public static String sqlTables = "SELECT " +
            "table_name FROM information_schema.tables" +
            " WHERE table_type = 'BASE TABLE' AND table_schema NOT " +
            "IN ('pg_catalog', 'information_schema')";

    public static String sqlFields = "SELECT a.attname FROM pg_catalog.pg_attribute a WHERE a.attrelid = " +
            "(SELECT c.oid FROM pg_catalog.pg_class c " +
            "LEFT JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace " +
            "WHERE pg_catalog.pg_table_is_visible(c.oid) AND c.relname = '%s' )" +
            " AND a.attnum > 0 AND NOT a.attisdropped";
}
