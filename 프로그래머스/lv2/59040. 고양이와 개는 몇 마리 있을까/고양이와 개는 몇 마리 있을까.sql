-- 코드를 입력하세요
select animal_type, count(*)  as count
from animal_ins
group by animal_type -- type별 그룹핑
having animal_type in('cat', 'dog')
order by 1;