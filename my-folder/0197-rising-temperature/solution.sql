-- Write your PostgreSQL query statement below
SELECT w.id
FROM Weather w
INNER JOIN Weather w2
ON w.recordDate - w2.recordDate = 1 AND w.temperature > w2.temperature;
