-- 코드를 입력하세요
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE),2) AS SCORE
FROM REST_INFO AS I INNER JOIN REST_REVIEW AS R
ON I.REST_ID = R.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY I.REST_ID
ORDER BY AVG(R.REVIEW_SCORE) DESC, I.FAVORITES DESC;