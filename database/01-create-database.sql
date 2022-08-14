-- **************************************************************
-- This script destroys and re-creates the database
--
-- It also drops the users associated with the database
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'e_learning';

DROP DATABASE IF EXISTS e_learning;
CREATE DATABASE e_learning;

DROP USER e_learning_owner;
DROP USER e_learning_appuser;
