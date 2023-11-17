insert into member (id, name, password) values (1, '사용자1', '1234');

insert into product(id, name, price, detail) values (1, '볼펜 겸용 터치펜', 9000, '볼펜과 터치펜을 하나로!');
insert into product(id, name, price, detail) values (2, '볼펜 겸용 터치 패드', 10000, '사면 바보 터치 패드');

insert into purchase_order(id, orderer_id, orderer_name, state, shipping_zip_code, shipping_addr1, shipping_addr2, receiver_name, receiver_phone, total_amounts, order_date)
values (1, 1, '사용자1', 'PREPARING', 'zipcode', 'addr1', 'addr2', '테1', '010-1234-5678', 19000, now());

insert into order_line(id,order_id, product_id, price, quantity, amounts)
values (null, 1, 1, 9000, 1, 9000);

insert into order_line(id,order_id, product_id, price, quantity, amounts)
values (null, 1, 2, 10000, 1, 10000);


