select substring(product_code, 1, 2), count(*)
from product
group by substring(product_code, 1, 2)

