insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400001', '2020-09-14 09:00:01','LOAN0220091400000001','2020-08-12',1,300,21,'6225883719240036','NORM');

insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400002', '2020-09-14 09:00:01','LOAN0220091400000001','2020-09-12',2,300,22,'6225883719240036','NORM');

insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091500002', '2020-09-14 09:00:01','LOAN0220091400000002','2020-09-12',2,300,22,'6225883719240035','NORM');

insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400003', '2020-09-14 09:00:01','LOAN0220091400000001','2020-10-12',3,300,23,'6225883719240036','NORM');

insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400004', '2020-09-14 09:00:01','LOAN0220091400000001','2020-11-12',4,300,24,'6225883719240036','NORM');


insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400005', '2020-09-14 09:00:01','LOAN0220091400000001','2020-12-12',4,300,25,'6225883719240036','NORM');

insert into repayment_plan(id, create_time,loan_id,due_dt,term_no,prcp_amt,prcp_int,repayment_bank_account,repay_sts)
values('PLAN2020091400006', '2020-09-14 09:00:01','LOAN0220091400000001','2021-01-12',4,300,26,'6225883719240036','NORM');




insert into repayment_detail(id, create_time,loan_id,repayment_plan_id,amount,repayment_bank_account,pay_serno,sts)
values('DETAIL2020091400001', '2020-09-14 09:00:01','LOAN0220091400000001','PLAN2020091400001',321,'6225883719240036','123','SUCCESS');

insert into repayment_detail(id, create_time,loan_id,repayment_plan_id,amount,repayment_bank_account,pay_serno,sts)
values('DETAIL2020091400002', '2020-09-14 09:00:01','LOAN0220091400000001','PLAN2020091400001',322,'6225883719240036','456','SUCCESS');

insert into repayment_detail(id, create_time,loan_id,repayment_plan_id,amount,repayment_bank_account,pay_serno,sts)
values('DETAIL2020091400003', '2020-09-14 09:00:01','LOAN0220091400000001','PLAN2020091400001',323,'6225883719240036','789','SUCCESS');
