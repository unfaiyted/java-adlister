USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;


CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) UNIQUE NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  main_id INT,
  title VARCHAR(240),
    PRIMARY KEY (id)
);

INSERT INTO categories (title,main_id)
    VALUES
      ('community',0),
      ('services',0),
      ('discussion',0),
      ('housing', 0),
      ('jobs', 0),
      ('personal',0),
      ('for sale',0);


SET @commID = (SELECT id FROM categories WHERE title = 'community');
SET @servID = (SELECT id FROM categories WHERE title = 'services');
SET @discID = (SELECT id FROM categories WHERE title = 'discussion');
SET @housID = (SELECT id FROM categories WHERE title = 'housing');
SET @jobsID = (SELECT id FROM categories WHERE title = 'jobs');
SET @persID = (SELECT id FROM categories WHERE title = 'personal');
SET @saleID = (SELECT id FROM categories WHERE title = 'for sale');

/* Community */
INSERT INTO categories (title, main_id)
    VALUES
      ('activities', @commID),
      ('artists', @commID),
      ('lost and found', @commID),
      ('pets', @commID),
      ('local news', @commID),
      ('childcare', @commID),
      ('rants', @commID)


/* Services */
INSERT INTO categories (title, main_id)
VALUES
  ('automotive', @servID),
  ('beauty', @servID),
  ('lessons', @servID),
  ('pets', @servID),
  ('travel', @servID),
  ('household', @servID),
  ('pet', @servID)


/* Services */
INSERT INTO categories (title, main_id)
VALUES
  ('linux', @discID),
  ('diet', @discID),
  ('divorce', @discID),
  ('religion', @discID),
  ('gaming', @discID),
  ('gardening', @discID),
  ('tv', @discID)

