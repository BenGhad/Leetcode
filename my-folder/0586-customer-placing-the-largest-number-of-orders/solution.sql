-- Write your PostgreSQL query statement below
SELECT customer_number FROM
(
SELECT customer_number, COUNT(*) AS cnt
FROM Orders
GROUP BY customer_number 
ORDER BY cnt DESC
LIMIT 1
);
