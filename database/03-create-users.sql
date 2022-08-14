-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER brewery_finder_owner WITH PASSWORD 'e_learning_owner1';

GRANT ALL 
ON ALL TABLES IN SCHEMA public
TO e_learning_owner;

GRANT ALL 
ON ALL SEQUENCES IN SCHEMA public
TO e_learning_owner;

CREATE USER brewery_finder_appuser WITH PASSWORD 'e_learning_appuser1';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO e_learning_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO e_learning_appuser;