create table if not exists repayment_detail (
    id varchar(32) not null,
    create_time datetime not null,
    loan_id varchar(32) not null,
    repayment_plan_id varchar(32) not null,
    amount decimal(12, 2) not null default 0,
    repayment_bank_account varchar(32) not null,
    version int,
    primary key (id)
);


create table if not exists repayment_plan (
    id varchar(32) not null,
    create_time datetime not null,
    loan_id varchar(32) not null,
    due_dt varchar(10) not null,
    term_no number(3) not null,
    prcp_amt decimal(12, 2) not null default 0,
    prcp_int decimal(12, 2) not null default 0,
    repayment_bank_account varchar(32) not null,
    version int,
    repay_sts varchar(10),
    primary key (id)
);
