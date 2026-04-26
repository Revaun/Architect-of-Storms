# Architect of Storms  
### CloudFormation Multi‑Tier Stack Project  
#### AWS Solutions Architect Portfolio Project

<p align="center">
  <img src="assets/banner.png" alt="Project Banner" width="1000"/>
</p>

<p align="center">
  <em>Architect of Storms – Forging Cloud Architecture from the Storm</em>
</p>

---

## About Me

I’m Revaun, a cloud solutions enthusiast and portfolio builder focused on AWS architecture, DevOps practices, and SQL analytics.  
My current goals include achieving AWS Solutions Architect Professional, Machine Learning Specialty, and Security Specialty certifications.  
I design recruiter‑ready projects that combine technical rigor with clear documentation, proof snapshots, and branding under the identity *Architect of Storms*.

### Key Skills
- **AWS CloudFormation** – Infrastructure as Code for scalable deployments  
- **Amazon RDS & SQL Analytics** – Data modeling, joins, reporting  
- **DevOps Practices** – CI/CD, automation, repo organization, workflow optimization  
- **Monitoring & Observability** – CloudWatch dashboards, alarms, budget alerts  
- **Documentation & Branding** – Recruiter‑ready polish, proof snapshots, clear repo structure  

---

## Architecture
- **VPC**: Isolated networking environment  
- **Application Load Balancer**: Host-based routing for web components  
- **EC2 Auto Scaling Group**: Scalable compute layer hosting the application  
- **Amazon RDS**: Managed relational database  
- **CloudWatch Monitoring**: Alarms and dashboards for observability  

---

## Features
- Automated deployment with IaC (CloudFormation)  
- Host-based routing for modular components  
- Scalable compute layer with Auto Scaling  
- Managed database with RDS  
- Monitoring and alerting with CloudWatch  
- SQL analytics queries for reporting and trends  

---

## Deployment

### Scripts

```bash
# Deploy the stack
./scripts/deploy.sh

# Cleanup resources
./scripts/cleanup.sh

---

SQL Analytics Queries

| Query | Purpose |
| --- | --- |
| **Basic Join** | Show combined user, order, and product details in one view. |
| **Product Sales Summary** | Summarize total sales and order counts per product. |
| **User Spending Summary** | Calculate how much each user has spent and how many orders they placed. |
| **Monthly Breakdown** | Provide month‑by‑month sales and order counts per product. |
| **Rolling 3‑Month Averages** | Smooth out sales trends with a moving average for each product. |

-- Basic Join
SELECT u.username, u.email, p.name AS product_name, o.amount, o.created_at
FROM users u
JOIN orders o ON u.id = o.user_id
JOIN products p ON o.product_id = p.id;

-- Product Sales Summary
SELECT p.name AS product_name,
       SUM(o.amount) AS total_sales,
       COUNT(*) AS orders_count
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY p.name;

-- User Spending Summary
SELECT u.username,
       COUNT(o.id) AS orders_count,
       SUM(o.amount) AS total_spent
FROM users u
JOIN orders o ON u.id = o.user_id
GROUP BY u.username;

-- Monthly Breakdown
SELECT YEAR(o.created_at) AS year,
       MONTH(o.created_at) AS month,
       p.name AS product_name,
       SUM(o.amount) AS total_sales,
       COUNT(*) AS orders_count
FROM orders o
JOIN products p ON o.product_id = p.id
GROUP BY YEAR(o.created_at), MONTH(o.created_at), p.name
ORDER BY year, month, product_name;

-- Rolling 3-Month Averages
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

    Infrastructure as Code simplifies repeatable deployments and cleanup.

    SQL syntax discipline prevents query errors.

    Schema integrity ensures data consistency.

    Joins across users, orders, and products build richer insights.

    Window functions enable rolling averages.

    Monitoring with CloudWatch provides visibility into system health.

    Documentation with snapshots creates undeniable proof of progress.
---

Issues Faced & Resolutions

    Duplicate Entry Error: Attempted to insert a user with an existing email.
    Resolution: Enforced unique constraints on schema.

    Dead Forecast Link: Forecast overlay PNG did not exist.
    Resolution: Removed reference to forecast snapshot.

    Excessive Badges/Quicklinks: README felt cluttered.
    Resolution: Slimmed down badges, removed “Connect with Me” and “Contribute” sections.
---

Project Completion

This project has been successfully completed with full proof snapshots and a reporting suite.
All schema definitions, data inserts, joins, summaries, time analysis, and rolling averages have been captured and documented.

Author: Revaun
Date: April 2026

---

License

This project is licensed under the MIT License.
You are free to use, modify, and distribute it with proper attribution.
---

Badges

https://img.shields.io/badge/AWS-Cloud-orange
https://img.shields.io/badge/DevOps-Workflow-blue
https://img.shields.io/badge/CloudWatch-Monitoring-green

---

Signature: Architect of Storms  
Proof in the Storm, Precision in the Cloud
