SELECT a.flavor FROM first_half a 
LEFT JOIN icecream_info b 
ON a.flavor = b.flavor 
WHERE b.INGREDIENT_TYPE LIKE 'fruit_based'
AND a.total_order > 3000 
ORDER BY a.total_order DESC;