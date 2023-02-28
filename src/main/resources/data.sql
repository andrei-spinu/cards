drop table if exists card cascade;

create table card (
    card_id bigserial not null,
    amount_used bigint,
    available_amount bigint,
    card_number varchar(255),
    card_type varchar(255),
    created_date date,
    customer_id bigint,
    total_limit bigint,
    primary key (card_id)
                  );

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, NOW());

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, NOW());

INSERT INTO card (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, NOW());