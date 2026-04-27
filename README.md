Architect of Storms
CloudFormation Multi‑Tier Stack Project
AWS Solutions Architect Portfolio Project

<p align="center">
<img src="assets/banner.png" alt="Project Banner" width="1000"/>
</p>

<p align="center">
<em>Architect of Storms – Forging Cloud Architecture from the Storm</em>
</p>
About Me

I’m Revaun, a cloud solutions enthusiast focused on AWS architecture, DevOps practices, and SQL analytics.
My goals: AWS Solutions Architect Pro, Machine Learning Specialty, Security Specialty certifications.
I design recruiter‑ready projects that combine technical rigor with clear documentation, proof snapshots, and branding.

Architecture Overview

    VPC – Isolated networking environment

    Application Load Balancer – Host‑based routing

    EC2 Auto Scaling Group – Scalable compute layer

    Amazon RDS – Managed relational database

    CloudWatch Monitoring – Alarms and dashboards

Features

    Automated deployment with IaC (CloudFormation)

    Host‑based routing for modular components

    Scalable compute layer with Auto Scaling

    Managed database with RDS

    Monitoring and alerting with CloudWatch

    SQL analytics queries for reporting and trends

Deployment

Scripts

    Deploy the stack: ./scripts/deploy.sh

    Cleanup resources: ./scripts/cleanup.sh

---

### SQL Analytics Queries
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


---

Proof Snapshots


<p align="center">

<a href="docs/proof-snapshots/account-setup.png">
<img src="docs/proof-snapshots/account-setup.png" width="150" alt="Account Setup"/><br/>
<strong>Account Setup</strong> – Initial AWS account and IAM configuration
</a>

<a href="docs/proof-snapshots/architecture-diagram.png">
<img src="docs/proof-snapshots/architecture-diagram.png" width="150" alt="Architecture Diagram"/><br/>
<strong>Architecture Diagram</strong> – High‑level AWS architecture showing VPC, subnets, and routing layers
</a>

<a href="docs/proof-snapshots/ec2-snapshots.png">
<img src="docs/proof-snapshots/ec2-snapshots.png" width="150" alt="EC2 Auto Scaling"/><br/>
<strong>EC2 Auto Scaling Group</strong> – Scalable compute layer hosting the application
</a>

<a href="docs/proof-snapshots/rds-instance.png">
<img src="docs/proof-snapshots/rds-instance.png" width="150" alt="RDS Instance"/><br/>
<strong>RDS Instance</strong> – Managed relational database deployment
</a>

<a href="docs/proof-snapshots/products-data.png">
<img src="docs/proof-snapshots/products-data.png" width="150" alt="Products Data"/><br/>
<strong>Products Data</strong> – Inserted product dataset for analytics
</a>

<a href="docs/proof-snapshots/users-data.png">
<img src="docs/proof-snapshots/users-data.png" width="150" alt="Users Data"/><br/>
<strong>Users Data</strong> – Inserted user dataset for analytics
</a>

<a href="docs/proof-snapshots/user-spending-summary.png">
<img src="docs/proof-snapshots/user-spending-summary.png" width="150" alt="User Spending Summary"/><br/>
<strong>User Spending Summary</strong> – Query results showing per‑user spending and order counts
</a>

<a href="docs/proof-snapshots/join-users-orders-products.png">
<img src="docs/proof-snapshots/join-users-orders-products.png" width="150" alt="Join Query"/><br/>
<strong>Join Users + Orders + Products</strong> – Combined query output for relational joins
</a>

<a href="docs/proof-snapshots/monthly-sales-summary.png">
<img src="docs/proof-snapshots/monthly-sales-summary.png" width="150" alt="Monthly Sales"/><br/>
<strong>Monthly Sales Summary</strong> – Month‑by‑month breakdown of product sales
</a>

<a href="docs/proof-snapshots/rolling-avg-sales.png">
<img src="docs/proof-snapshots/rolling-avg-sales.png" width="150" alt="Rolling Average"/><br/>
<strong>Rolling Average Sales</strong> – Moving average query output for trend smoothing
</a>

</p>

---

Lessons Learned

    Infrastructure as Code simplifies repeatable deployments

    SQL syntax discipline prevents query errors

    Schema integrity ensures data consistency

    Joins build richer insights

    Window functions enable rolling averages

    Monitoring with CloudWatch provides visibility

    Documentation with snapshots proves progress

---


Issues Faced & Resolutions

    Duplicate Entry Error → enforced unique constraints

    Dead Forecast Link → removed broken reference

    Excessive Badges → slimmed down for clarity

---

Completion

Project completed with full proof snapshots and reporting suite.
Author: Revaun • Date: April 2026

---

License

MIT License — free to use, modify, distribute with attribution.

---

Badges

https://img.shields.io/badge/AWS-Cloud-orange  
https://img.shields.io/badge/DevOps-Workflow-blue  
https://img.shields.io/badge/CloudWatch-Monitoring-green

---

Signature
<p align="center"><strong>Architect of Storms</strong><br/>
<em>Proof in the Storm, Precision in the Cloud</em></p>
