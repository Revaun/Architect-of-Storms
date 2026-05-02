# Architect of Storms  
*Forging Cloud Architecture from the Storm*

---

<p align="center">
  <img src="assets/banner.png" alt="Project Banner" width="1000"/>
</p>

<p align="center">
  <em>Architect of Storms – Forging Cloud Architecture from the Storm</em>
</p>

***

## About Me

I'm Revaun, building resilient AWS solutions with a focus on CloudFormation, DevOps, and SQL analytics.  
Career goals: AWS Solutions Architect Pro • Machine Learning Specialty • Security Specialty

- ![AWS Solutions Architect Pro](https://img.shields.io/badge/AWS-SAP-orange?style=flat-square) — Professional certification goal  
- ![AWS Machine Learning Specialty](https://img.shields.io/badge/AWS-MLS-blue?style=flat-square) — ML specialty focus  
- ![AWS Security Specialty](https://img.shields.io/badge/AWS-SEC-red?style=flat-square) — Security specialty track  
- ![DevOps Workflow](https://img.shields.io/badge/DevOps-Workflow-green?style=flat-square) — Workflow automation & CI/CD


---

## Architecture Overview
This project demonstrates a multi‑tier CloudFormation stack with scalable services, monitoring, and analytics.

- **VPC** – Isolated networking environment  
- **Application Load Balancer** – Host‑based routing  
- **EC2 Auto Scaling Group** – Scalable compute layer  
- **Amazon RDS** – Managed relational database  
- **CloudWatch Monitoring** – Alarms and dashboards  


## Features
- Automated deployment with IaC (CloudFormation)  
- Host‑based routing for modular components  
- Scalable compute layer with Auto Scaling  
- Managed database with RDS  
- Monitoring and alerting with CloudWatch  
- SQL analytics queries for reporting and trends  

## Deployment
Scripts are provided for quick setup and teardown.


## SQL Analytics Query
---

| Query | Purpose |
| --- | --- |
| **Basic Join** | Combine user, order, and product details |
| **Product Sales Summary** | Summarize sales and order counts per product |
| **User Spending Summary** | Calculate per‑user spending and order counts |
| **Monthly Breakdown** | Month‑by‑month sales and order counts |
| **Rolling 3‑Month Averages** | Smooth trends with moving averages |

<details>
<summary><strong>Basic Join</strong></summary>

SELECT u.username, u.email, p.name AS product_name, o.amount, o.created_at
FROM users u
JOIN orders o ON u.id = o.user_id
JOIN products p ON o.product_id = p.id;
</details>

<details>
<summary><strong>Product Sales Summary</strong></summary>

SELECT p.name AS product_name,
       SUM(o.amount) AS total_sales,
       COUNT(*) AS orders_count
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY p.name;


</details>

<details>
<summary><strong>User Spending Summary</strong></summary>

SELECT u.username,
       COUNT(o.id) AS orders_count,
       SUM(o.amount) AS total_spent
FROM users u
JOIN orders o ON u.id = o.user_id
GROUP BY u.username;

</details>

<details>
<summary><strong>Monthly Breakdown</strong></summary>

SELECT YEAR(o.created_at) AS year,
       MONTH(o.created_at) AS month,
       p.name AS product_name,
       SUM(o.amount) AS total_sales,
       COUNT(*) AS orders_count
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY YEAR(o.created_at), MONTH(o.created_at), p.name
ORDER BY year, month, product_name;

</details>

<details>
<summary><strong>Rolling 3‑Month Averages</strong></summary>

SELECT p.name AS product_name,
       DATE_FORMAT(o.created_at, '%Y-%m') AS month,
       AVG(SUM(o.amount)) OVER (
           PARTITION BY p.name
           ORDER BY DATE_FORMAT(o.created_at, '%Y-%m')
           ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
       ) AS rolling_avg_sales
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY p.name, DATE_FORMAT(o.created_at, '%Y-%m')
ORDER BY p.name, month;

</details>


## 📸 Proof Snapshots

**From setup to completion: a full proof trail of the Architect of Storms build**


| Stage | Snapshot |
|-------|----------|
| **Account Setup** | <img src="docs/proof-snapshots/account-setup.png" width="300" alt="Account Setup"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/account-setup.png?raw=true) |
| **Agent Status** | <img src="docs/proof-snapshots/agent-status.png" width="300" alt="Agent Status"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/agent-status.png?raw=true) |
| **ALB Created** | <img src="docs/proof-snapshots/alb-created.png" width="300" alt="ALB Created"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/alb-created.png?raw=true) |
| **Architecture Diagram** | <img src="docs/proof-snapshots/architecture-diagram.png" width="300" alt="Architecture Diagram"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/architecture-diagram.png?raw=true) |
| **DB Security Group** | <img src="docs/proof-snapshots/db-sg.png" width="300" alt="DB Security Group"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/db-sg.png?raw=true) |
| **DB Subnet Group** | <img src="docs/proof-snapshots/db-subnet-group.png" width="300" alt="DB Subnet Group"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/db-subnet-group.png?raw=true) |
| **EC2 AMIs** | <img src="docs/proof-snapshots/ec2-amis.png" width="300" alt="EC2 AMIs"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ec2-amis.png?raw=true) |
| **EC2 Snapshots** | <img src="docs/proof-snapshots/ec2-snapshots.png" width="300" alt="EC2 Snapshots"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ec2-snapshots.png?raw=true) |
| **EC2 SSM Inline Policy** | <img src="docs/proof-snapshots/ec2-ssm-inline-policy.png" width="300" alt="EC2 SSM Inline Policy"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ec2-ssm-inline-policy.png?raw=true) |
| **IAM Role Attached** | <img src="docs/proof-snapshots/iam-role-attached.png" width="300" alt="IAM Role Attached"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/iam-role-attached.png?raw=true) |
| **Join Users + Orders + Products** | <img src="docs/proof-snapshots/join-users-orders-products.png" width="300" alt="Join Query"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/join-users-orders-products.png?raw=true) |
| **Monthly Sales Summary** | <img src="docs/proof-snapshots/monthly-sales-summary.png" width="300" alt="Monthly Sales Summary"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/monthly-sales-summary.png?raw=true) |
| **Orders Schema** | <img src="docs/proof-snapshots/orders-schema.png" width="300" alt="Orders Schema"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/orders-schema.png?raw=true) |
| **Product Sales Summary** | <img src="docs/proof-snapshots/product-sales-summary.png" width="300" alt="Product Sales Summary"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/product-sales-summary.png?raw=true) |
| **Products Data** | <img src="docs/proof-snapshots/products-data.png" width="300" alt="Products Data"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/products-data.png?raw=true) |
| **Products Schema** | <img src="docs/proof-snapshots/products-schema.png" width="300" alt="Products Schema"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/products-schema.png?raw=true) |
| **RDS Created** | <img src="docs/proof-snapshots/rds-created.png" width="300" alt="RDS Created"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-created.png?raw=true) |
| **RDS Instance** | <img src="docs/proof-snapshots/rds-instance.png" width="300" alt="RDS Instance"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-instance.png?raw=true) |
| **RDS Snapshots** | <img src="docs/proof-snapshots/rds-snapshots.png" width="300" alt="RDS Snapshots"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-snapshots.png?raw=true) |
| **RDS Stack Complete** | <img src="docs/proof-snapshots/rds-stack-complete.png" width="300" alt="RDS Stack Complete"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-stack-complete.png?raw=true) |
| **Repo Layout** | <img src="docs/proof-snapshots/repo-layout.png" width="300" alt="Repo Layout"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/repo-layout.png?raw=true) |
| **Role Attachment** | <img src="docs/proof-snapshots/role-attachment.png" width="300" alt="Role Attachment"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/role-attachment.png?raw=true) |
| **Rolling Average Sales** | <img src="docs/proof-snapshots/rolling-avg-sales.png" width="300" alt="Rolling Average Sales"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rolling-avg-sales.png?raw=true) |
| **Session Logging** | <img src="docs/proof-snapshots/session-logging.png" width="300" alt="Session Logging"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/session-logging.png?raw=true) |
| **SSM Registration** | <img src="docs/proof-snapshots/ssm-registration.png" width="300" alt="SSM Registration"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ssm-registration.png?raw=true) |
| **Stack Created** | <img src="docs/proof-snapshots/stack-created.png" width="300" alt="Stack Created"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/stack-created.png?raw=true) |
| **User Spending Summary** | <img src="docs/proof-snapshots/user-spending-summary.png" width="300" alt="User Spending Summary"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/user-spending-summary.png?raw=true) |
| **Users Data** | <img src="docs/proof-snapshots/users-data.png" width="300" alt="Users Data"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/users-data.png?raw=true) |
| **Users Schema** | <img src="docs/proof-snapshots/users-schema.png" width="300" alt="Users Schema"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/users-schema.png?raw=true) |
| **VPC Created** | <img src="docs/proof-snapshots/vpc-created.png" width="300" alt="VPC Created"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/vpc-created.png?raw=true) |
| **CloudFormation Stacks** | <img src="docs/proof-snapshots/cloudformation-stacks.png" width="300" alt="CloudFormation Stacks"/> [🔗 Full Image](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/cloudformation-stacks.png?raw=true) |




</details>


## Lessons Learned
- **Infrastructure as Code** simplifies repeatable deployments  
- **SQL syntax discipline** prevents query errors  
- **Schema integrity** ensures data consistency  
- **Joins** build richer insights  
- **Window functions** enable rolling averages  
- **Monitoring with CloudWatch** provides visibility  
- **Documentation with snapshots** proves progress  

</details>

## Issues Faced & Resolutions
- **Duplicate Entry Error** → enforced unique constraints  
- **Dead Forecast Link** → removed broken reference  
- **Excessive Badges** → slimmed down for clarity  

## Completion
**This project demonstrates the full lifecycle — from design to proof in the storm.**

Project completed with full proof snapshots and reporting suite.  
**Author:** Revaun • **Date:** April 2026   

## License
MIT License — free to use, modify, and distribute with attribution.  

## Signature
**Architect of Storms**  
*From design to storm, precision in the cloud*

---

<p align="center">
  <em>Proof in the Storm, Precision in the Cloud ☁️</em>
</p>