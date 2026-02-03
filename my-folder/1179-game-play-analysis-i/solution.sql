-- Write your PostgreSQL query statement below
SELECT A.player_id, MIN(event_date) as first_login
FROM Activity A
GROUP BY player_id;

