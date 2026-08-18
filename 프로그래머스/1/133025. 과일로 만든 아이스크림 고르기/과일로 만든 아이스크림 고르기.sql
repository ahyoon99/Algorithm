select a.flavor
from first_half a
    inner join icecream_info b
    on a.flavor = b.flavor
where a.total_order >= 3000 and ingredient_type='fruit_based'
order by a.total_order desc