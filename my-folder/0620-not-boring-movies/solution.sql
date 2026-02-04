-- Write your PostgreSQL query statement below
SELECT * FROM Cinema m
WHERE m.id % 2 <> 0 AND m.description <> 'boring'
ORDER BY m.rating DESC;
