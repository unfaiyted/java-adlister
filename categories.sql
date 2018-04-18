
# Returns Cat/subcat in list order
SELECT  c.id,
  coalesce(c.main_id, c1.main_id) as subCatId,
  c.title as mainCatName

FROM categories c
  LEFT OUTER JOIN categories c1 ON (c1.id = c.main_id)
ORDER BY coalesce(c1.title, c.title), c1.main_id;
