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
| **Account Setup** | <img src="docs/proof-snapshots/account-setup.png" width="300" alt="Account Setup"/> |
| **Agent Status** | <img src="docs/proof-snapshots/agent-status.png" width="300" alt="Agent Status"/> |
| **ALB Created** | <img src="docs/proof-snapshots/alb-created.png" width="300" alt="ALB Created"/> |
| **Architecture Diagram** | <img src="docs/proof-snapshots/architecture-diagram.png" width="300" alt="Architecture Diagram"/> |
| **DB Security Group** | <img src="docs/proof-snapshots/db-sg.png" width="300" alt="DB Security Group"/> |
| **DB Subnet Group** | <img src="docs/proof-snapshots/db-subnet-group.png" width="300" alt="DB Subnet Group"/> |
| **EC2 AMIs** | <img src="docs/proof-snapshots/ec2-amis.png" width="300" alt="EC2 AMIs"/> |
| **EC2 Snapshots** | <img src="docs/proof-snapshots/ec2-snapshots.png" width="300" alt="EC2 Snapshots"/> |
| **EC2 SSM Inline Policy** | <img src="docs/proof-snapshots/ec2-ssm-inline-policy.png" width="300" alt="EC2 SSM Inline Policy"/> |
| **IAM Role Attached** | <img src="docs/proof-snapshots/iam-role-attached.png" width="300" alt="IAM Role Attached"/> |
| **Join Users + Orders + Products** | <img src="docs/proof-snapshots/join-users-orders-products.png" width="300" alt="Join Query"/> |
| **Monthly Sales Summary** | <img src="docs/proof-snapshots/monthly-sales-summary.png" width="300" alt="Monthly Sales Summary"/> |
| **Orders Schema** | <img src="docs/proof-snapshots/orders-schema.png" width="300" alt="Orders Schema"/> |
| **Product Sales Summary** | <img src="docs/proof-snapshots/product-sales-summary.png" width="300" alt="Product Sales Summary"/> |
| **Products Data** | <img src="docs/proof-snapshots/products-data.png" width="300" alt="Products Data"/> |
| **Products Schema** | <img src="docs/proof-snapshots/products-schema.png" width="300" alt="Products Schema"/> |
| **RDS Created** | <img src="docs/proof-snapshots/rds-created.png" width="300" alt="RDS Created"/> |
| **RDS Instance** | <img src="docs/proof-snapshots/rds-instance.png" width="300" alt="RDS Instance"/> |
| **RDS Snapshots** | <img src="docs/proof-snapshots/rds-snapshots.png" width="300" alt="RDS Snapshots"/> |
| **RDS Stack Complete** | <img src="docs/proof-snapshots/rds-stack-complete.png" width="300" alt="RDS Stack Complete"/> |
| **Repo Layout** | <img src="docs/proof-snapshots/repo-layout.png" width="300" alt="Repo Layout"/> |
| **Role Attachment** | <img src="docs/proof-snapshots/role-attachment.png" width="300" alt="Role Attachment"/> |
| **Rolling Average Sales** | <img src="docs/proof-snapshots/rolling-avg-sales.png" width="300" alt="Rolling Average Sales"/> |
| **Session Logging** | <img src="docs/proof-snapshots/session-logging.png" width="300" alt="Session Logging"/> |
| **SSM Registration** | <img src="docs/proof-snapshots/ssm-registration.png" width="300" alt="SSM Registration"/> |
| **Stack Created** | <img src="docs/proof-snapshots/stack-created.png" width="300" alt="Stack Created"/> |
| **User Spending Summary** | <img src="docs/proof-snapshots/user-spending-summary.png" width="300" alt="User Spending Summary"/> |
| **Users Data** | <img src="docs/proof-snapshots/users-data.png" width="300" alt="Users Data"/> |
| **Users Schema** | <img src="docs/proof-snapshots/users-schema.png" width="300" alt="Users Schema"/> |
| **VPC Created** | <img src="docs/proof-snapshots/vpc-created.png" width="300" alt="VPC Created"/> |
| **Final Multi‑Tier Deployment** | <img src="docs/proof-snapshots/Architect-of-Storms_Final-Multi-Tier-Deployment-Snapshot.png" width="300" alt="Final Multi‑Tier Deployment"/> |




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