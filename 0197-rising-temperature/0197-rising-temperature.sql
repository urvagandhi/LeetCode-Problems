SELECT w1.id 
FROM Weather w1
JOIN Weather w2 
  ON w2.recordDate < w1.recordDate 
  AND w2.temperature < w1.temperature
WHERE ABS(DATEDIFF(w1.recordDate, w2.recordDate)) = 1;
