-- 코드를 입력하세요
SELECT car_type, COUNT(*)
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%가죽시트%' OR OPTIONS LIKE '%열선시트%' OR OPTIONS LIKE '%통풍시트%'
GROUP BY car_type
ORDER BY car_type