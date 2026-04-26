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
- **Amazon RDS & SQL Analytics** – Data modeling, joins, forecasting, reporting  
- **DevOps Practices** – CI/CD, automation, repo organization, workflow optimization  
- **Monitoring & Observability** – CloudWatch dashboards, alarms, budget alerts  
- **Documentation & Branding** – Recruiter‑ready polish, proof snapshots, clear repo structure  

### Career Goals
- Earn AWS **Solutions Architect Professional**, **Machine Learning Specialty**, and **Security Specialty** certifications  
- Transition into advanced **DevOps and Cloud Engineering roles** with a focus on automation and resilience  
- Build a portfolio of **production‑ready projects** that demonstrate technical depth and recruiter‑ready polish  

### Highlights
- Designed and deployed a **multi‑tier AWS CloudFormation stack** with automated scaling and monitoring  
- Built a **SQL analytics suite** with joins, summaries, rolling averages, and forecasting overlays  
- Captured **proof snapshots** at every stage for undeniable recruiter‑ready evidence  
- Integrated **branding and documentation polish** under the identity *Architect of Storms*  

### Quick Links

<p align="center">
  <a href="#overview">
    <img src="https://img.shields.io/badge/Overview-Read-blue?style=for-the-badge&logo=readme"/>
  </a>
  <a href="#architecture">
    <img src="https://img.shields.io/badge/Architecture-Design-orange?style=for-the-badge&logo=aws"/>
  </a>
  <a href="#features">
    <img src="https://img.shields.io/badge/Features-Explore-green?style=for-the-badge&logo=github"/>
  </a>
  <a href="#deployment">
    <img src="https://img.shields.io/badge/Deployment-Scripts-yellow?style=for-the-badge&logo=linux"/>
  </a>
  <a href="#proof-snapshots">
    <img src="https://img.shields.io/badge/Snapshots-Proof-lightgrey?style=for-the-badge&logo=googlephotos"/>
  </a>
  <a href="#snapshot-gallery">
    <img src="https://img.shields.io/badge/Gallery-Thumbnails-purple?style=for-the-badge&logo=images"/>
  </a>
  <a href="#lessons-learned">
    <img src="https://img.shields.io/badge/Lessons-Learned-red?style=for-the-badge&logo=bookstack"/>
  </a>
  <a href="#issues-faced--resolutions">
    <img src="https://img.shields.io/badge/Issues-Resolutions-brown?style=for-the-badge&logo=git"/>
  </a>
  <a href="#project-completion">
    <img src="https://img.shields.io/badge/Completion-Done-darkgreen?style=for-the-badge&logo=checkmarx"/>
  </a>
  <a href="#connect-with-me">
    <img src="https://img.shields.io/badge/Connect-Contact-blueviolet?style=for-the-badge&logo=linkedin"/>
  </a>
  <a href="#contributing">
    <img src="https://img.shields.io/badge/Contributing-Guide-brightgreen?style=for-the-badge&logo=github"/>
  </a>
  <a href="#license">
    <img src="https://img.shields.io/badge/License-MIT-black?style=for-the-badge&logo=open-source-initiative"/>
  </a>
</p>

---

![AWS Badge](https://img.shields.io/badge/AWS-CloudFormation-orange)
![SQL Badge](https://img.shields.io/badge/MySQL-Analytics-blue)
![DevOps Badge](https://img.shields.io/badge/DevOps-Portfolio-green)
![Monitoring Badge](https://img.shields.io/badge/CloudWatch-Monitoring-yellow)

---

## Architecture
- **VPC**: Isolated networking environment.
- **Application Load Balancer**: Host-based routing for web components.
- **EC2 Auto Scaling Group**: Scalable compute layer hosting the application.
- **Amazon RDS**: Managed relational database.
- **CloudWatch Monitoring**: Alarms and dashboards for observability.

---

## Features
- Automated deployment with IaC (CloudFormation).
- Host-based routing for modular components.
- Scalable compute layer with Auto Scaling.
- Managed database with RDS.
- Monitoring and alerting with CloudWatch.
- SQL analytics queries for reporting, trends, and forecasts.

---
# Deployment
./scripts/deploy.sh

# Cleanup
./scripts/cleanup.sh

# SQL Analytics Queries

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

## Proof Snapshots

Below are the captured proof images documenting each stage of the project.  
Click the thumbnails to view the full screenshots.

<p align="center">
<img src="docs/proof-snapshots/account-setup.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/architecture-diagram.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/ec2-snapshots.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/rds-instance.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/products-data.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/users-data.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/user-spending-summary.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/join-users-orders-products.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/monthly-sales-summary.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/rolling-avg-sales.png" width="600"/>
</p>

<p align="center">
<img src="docs/proof-snapshots/forecast-overlay.png" width="600"/>
</p>

---

## Snapshot Gallery

Quick thumbnail strip for fast scanning:

<p>
<img src="docs/proof-snapshots/account-setup.png" width="150"/>
<img src="docs/proof-snapshots/architecture-diagram.png" width="150"/>
<img src="docs/proof-snapshots/ec2-snapshots.png" width="150"/>
<img src="docs/proof-snapshots/rds-instance.png" width="150"/>
<img src="docs/proof-snapshots/products-data.png" width="150"/>
<img src="docs/proof-snapshots/users-data.png" width="150"/>
<img src="docs/proof-snapshots/user-spending-summary.png" width="150"/>
<img src="docs/proof-snapshots/join-users-orders-products.png" width="150"/>
<img src="docs/proof-snapshots/monthly-sales-summary.png" width="150"/>
<img src="docs/proof-snapshots/rolling-avg-sales.png" width="150"/>
<img src="docs/proof-snapshots/forecast-overlay.png" width="150"/>
</p>

---


## Lessons Learned

    Infrastructure as Code: CloudFormation templates simplify repeatable deployments and cleanup.

    SQL Syntax Discipline: Small typos caused errors; validating queries line by line fixed them.

    Schema Integrity: Unique constraints prevented duplicate entries.

    Joins Mastery: Learned to properly join across users, orders, and products.

    Window Functions: Gained experience with rolling averages using ROWS BETWEEN 2 PRECEDING AND CURRENT ROW.

    Forecasting: Overlaying linear regression forecasts provided forward-looking insights.

    Monitoring: CloudWatch alarms and dashboards gave visibility into system health.

    Documentation: Capturing snapshots at each stage provided undeniable proof of progress.

---

## Issues Faced & Resolutions

    Duplicate Entry Error: Attempted to insert a user with an existing email.
    Resolution: Added unique constraint and corrected insert statements.

    Environment Mismatches: Needed to adapt Linux-style snippets to PowerShell/MySQL CLI formatting.
    Resolution: Adjusted syntax and validated against manuals.

    Budget Alarm Triggered: AWS Budget alert email showed forecasted spend exceeding $10 cap.
    Resolution: Reviewed EC2 instances, deleted unused ENIs, and confirmed billing alerts. Snapshot included in repo.

---

## Project Completion

This project has been successfully completed with full proof snapshots and a reporting suite.  
All schema definitions, data inserts, joins, summaries, time analysis, rolling averages, and forecast overlays have been captured and documented.

Author: Revaun  
Date: April 2026

---

## Closing Statement

This project embodies my approach as the *Architect of Storms*: blending technical depth, clear documentation, and recruiter‑ready polish.  
It stands as both a showcase of AWS and SQL expertise and an invitation to collaborate, contribute, and connect.

*— Revaun, Architect of Storms*
*— Proof in the Storm, Precision in the Cloud*

---

## Connect With Me

<p align="center">
  <a href="https://www.linkedin.com/in/revaun-souls-a653763b6" target="_blank">
    <img src="https://img.shields.io/badge/LinkedIn-Connect-blue?style=for-the-badge&logo=linkedin"/>
  </a>
  <a href="https://github.com/Revaun/Architect-of-Storms" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-Portfolio-black?style=for-the-badge&logo=github"/>
  </a>
  <a href="mailto:revaun@gmail.com">
    <img src="https://img.shields.io/badge/Email-Contact-red?style=for-the-badge&logo=gmail"/>
  </a>
</p>

---

## Contributing

<p align="center">
  <img src="https://img.shields.io/badge/Contributions-Welcome-brightgreen?style=for-the-badge&logo=github"/>
</p>

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on how to fork, branch, and submit pull requests.

---

## License

This project is licensed under the **MIT License**.  
You are free to use, modify, and distribute it with proper attribution.  

See the [LICENSE](LICENSE) file for full details.

---

<p align="center">
  <a href="#connect-with-me">
    <img src="https://img.shields.io/badge/Connect-LinkedIn%20|%20GitHub%20|%20Email-blueviolet?style=for-the-badge&logo=linkedin"/>
  </a>
  <a href="#contributing">
    <img src="https://img.shields.io/badge/Contribute-Open%20Source%20Guide-brightgreen?style=for-the-badge&logo=github"/>
  </a>
  <a href="#license">
    <img src="https://img.shields.io/badge/License-MIT-black?style=for-the-badge&logo=open-source-initiative"/>
  </a>
</p>

# Architect of Storms
## Powered by AWS & Nyvara Stormweaver
Multi‑Tier CloudFormation Stack &amp; SQL Analytics project. Infrastructure as Code, scalable AWS architecture, and recruiter‑ready visuals.

