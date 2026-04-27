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


## Proof Snapshots
---

<p align="center">
  <!-- Thumbnail grid or images go here -->
</p>


| Description | Snapshot |
|-------------|----------|
| Account setup | [![Account Setup](docs/proof-snapshots/account-setup.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/account-setup.png) |
| Agent service status | [![Agent Status](docs/proof-snapshots/agent-status.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/agent-status.png) |
| ALB created | [![ALB Created](docs/proof-snapshots/alb-created.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/alb-created.png) |
| Architecture diagram | [![Architecture Diagram](docs/proof-snapshots/architecture-diagram.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/architecture-diagram.png) |
| DB security group | [![DB SG](docs/proof-snapshots/db-sg.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/db-sg.png) |
| DB subnet group | [![DB Subnet](docs/proof-snapshots/db-subnet-group.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/db-subnet-group.png) |
| EC2 AMIs | [![EC2 AMIs](docs/proof-snapshots/ec2-amis.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ec2-amis.png) |
| EC2 snapshots | [![EC2 Snapshots](docs/proof-snapshots/ec2-snapshots.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/ec2-snapshots.png) |
| IAM role attached | [![IAM Role](docs/proof-snapshots/iam-role-attached.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/iam-role-attached.png) |
| RDS instance | [![RDS Instance](docs/proof-snapshots/rds-instance.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-instance.png) |
| RDS snapshots | [![RDS Snapshots](docs/proof-snapshots/rds-snapshots.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rds-snapshots.png) |
| SQL join proof | [![Join Users Orders Products](docs/proof-snapshots/join-users-orders-products.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/join-users-orders-products.png) |
| Monthly sales summary | [![Monthly Sales](docs/proof-snapshots/monthly-sales-summary.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/monthly-sales-summary.png) |
| Rolling average sales | [![Rolling Avg](docs/proof-snapshots/rolling-avg-sales.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/rolling-avg-sales.png) |
| User spending summary | [![User Spending](docs/proof-snapshots/user-spending-summary.png)](https://github.com/Revaun/Architect-of-Storms/blob/main/docs/proof-snapshots/user-spending-summary.png) |

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
Project completed with full proof snapshots and reporting suite.  
**Author:** Revaun • **Date:** April 2026  

## License
MIT License — free to use, modify, and distribute with attribution.  

## Signature
**Architect of Storms**  
*Proof in the Storm, Precision in the Cloud*

---

<p align="center">
  <em>Proof in the Storm, Precision in the Cloud ☁️</em>
</p>