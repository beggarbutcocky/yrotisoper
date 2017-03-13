
/* select ALL */
SELECT * FROM users;
SELECT * FROM role;
SELECT * FROM user_claim;
SELECT * FROM shop;


/* insert roles */
INSERT INTO role (id, name) VALUES
  (nextval('role_id_seq'), 'admin');
INSERT INTO role (id, name) VALUES
  (nextval('role_id_seq'), 'client');

/* insert users */
INSERT INTO users (id, email, enabled, full_name, login, password, role_id) VALUES
  (nextval('users_id_seq'), 'genabukin@gmail.com', true, 'Gena Bukin', 'Andrew', 'password', 2);
INSERT INTO users (id, email, enabled, full_name, login, password, role_id) VALUES
  (nextval('users_id_seq'), 'veselii_palii@gmail.com', true, 'Veseliy Palii', 'Konstantin', 'password',  2);
INSERT INTO users (id, email, enabled, full_name, login, password, role_id) VALUES
  (nextval('users_id_seq'), 'dmitriiShafutinskiy@gmail.com', true, 'Dmitrii Shafutinskiy', 'Mikhail', 'password', 1);

/* insert product */
INSERT INTO product (id, description, image, name, price) VALUES
  (nextval('product_id_seq'), 'Mobile phone Nokia 3310', 'http://cdn2.gsmarena.com/vv/bigpic/nokia-3310-2017.jpg', 'Nokia 3310', 20);
INSERT INTO product (id, description, image, name, price) VALUES
  (nextval('product_id_seq'), 'Smart TV ', 'http://satinet.info/wp-content/uploads/2015/05/dckiksbsuyomwbs1paqs.png', 'Samsung LED TV Серия 4', 1100);
INSERT INTO product (id, description, image, name, price) VALUES
  (nextval('product_id_seq'), 'Refrigerator ', 'http://i1.rozetka.ua/goods/1792377/bosch_kgn36nl30u_images_1792377750.jpg', 'BOSCH KGN36NL30U', 800);


/* insert comments */
INSERT INTO comment (id, comment_text, user_id, product_id) VALUES
  (nextval('comment_id_seq'), 'comment text for Mikhail', 3, 1);
INSERT INTO comment (id, comment_text, user_id, product_id) VALUES
  (nextval('comment_id_seq'), 'comment text for Konstantin', 2, 1);
INSERT INTO comment (id, comment_text, user_id, product_id) VALUES
  (nextval('comment_id_seq'), 'comment text for Andrew', 1, 3);


/* insert user_claim */
INSERT INTO user_claim (id, claim_text, user_id, comment_id) VALUES
  (nextval('user_claim_id_seq'), 'some userclaim text for Mikhail ', 3, 1);
INSERT INTO user_claim (id, claim_text, user_id, comment_id) VALUES
  (nextval('user_claim_id_seq'), 'some userclaim text for Konstantin ', 2, 2);
INSERT INTO user_claim (id, claim_text, user_id, comment_id) VALUES
  (nextval('user_claim_id_seq'), 'some userclaim text for Andrew ', 1, 3);

/* insert shop_mention */
INSERT INTO shop_mention (id, comment_url, comment_text, user_id) VALUES
  (nextval('shop_mention_id_seq'), 'http://comment.com', 'some text for shop mention', 1);

/* insert tag */
INSERT INTO tag (id, name) VALUES
  (nextval('tag_id_seq'), 'Phones');
INSERT INTO tag (id, name) VALUES
  (nextval('tag_id_seq'), 'TV');
INSERT INTO tag (id, name) VALUES
  (nextval('tag_id_seq'), 'fridge');

/* insert product_tag */
INSERT INTO product_tag (id, tag_id, product_id) VALUES
  (nextval('product_tag_id_seq'), 1,1);
INSERT INTO product_tag (id, tag_id, product_id) VALUES
  (nextval('product_tag_id_seq'), 2, 2);
INSERT INTO product_tag (id, tag_id, product_id) VALUES
  (nextval('product_tag_id_seq'), 3, 3);

/* insert product_categories */
INSERT INTO product_category (id, name) VALUES
  (nextval('product_category_id_seq'), 'Electronics');
INSERT INTO product_category (id, name, parent_category_id) VALUES
  (nextval('product_category_id_seq'), 'Phones', 1);

/* insert discount */
INSERT INTO discount (id, product_category_id, percent) VALUES
  (nextval('discount_id_seq'), 2, 20);

/* insert shop */
INSERT INTO shop (id, name,  address, phone_number) VALUES
  (nextval('shop_id_seq'), 'Rozetka', 'Dovzhenka st. 14', '0934113774');
INSERT INTO shop (id, name,  address, phone_number) VALUES
  (nextval('shop_id_seq'), 'Allo', 'Teligi st. 3', '09533322211');

/* insert product_in_shop */
INSERT INTO product_in_shop (id, amount, product_id, shop_id, user_id) VALUES
  (nextval('product_in_shop_id_seq'), 300, 3, 1, 1);
INSERT INTO product_in_shop (id, amount, product_id, shop_id, user_id) VALUES
  (nextval('product_in_shop_id_seq'), 500, 1, 2, 3);
INSERT INTO product_in_shop (id, amount, product_id, shop_id, user_id) VALUES
  (nextval('product_in_shop_id_seq'), 800, 2, 2, 2);

/* insert bounty */
INSERT INTO bounty (id, shop_mention_id, sum, user_id ) VALUES
  (nextval('bounty_id_seq'), 1, 20, 1);

/* insert bounty */
INSERT INTO bonus (id, user_id, sum, percent, product_category_id ) VALUES
  (nextval('bonus_id_seq'), 2, 20, 10, 2);

/* order_item */
INSERT INTO order_item (id, product_id, user_id, amount) VALUES
  (nextval('order_item_id_seq'), 2, 3, 1);
INSERT INTO order_item (id, product_id, user_id, amount) VALUES
  (nextval('order_item_id_seq'), 1, 2, 1);
INSERT INTO order_item (id, product_id, user_id, amount) VALUES
  (nextval('order_item_id_seq'), 3, 1, 1);

/* insert order */
INSERT INTO orders (id, order_item_id, address, phone_number, bounty_id) VALUES
  (nextval('order_id_seq'), 1, 'Some order address', '093123234', 1);
INSERT INTO orders (id, order_item_id, address, phone_number) VALUES
  (nextval('order_id_seq'), 2, 'Some order address', '0933244334');
INSERT INTO orders (id, order_item_id, address, phone_number) VALUES
  (nextval('order_id_seq'), 3, 'Some order address', '093123234');



/* insert waybill */
INSERT INTO waybill (id, order_id, date, sum) VALUES
  (nextval('waybill_id_seq'), 1, '18.05.1993', 300);

INSERT INTO order_claim (id, user_id, order_id, claim_text) VALUES
  (nextval('order_claim_id_seq'), 2, 1, 'Some text for order claim');
