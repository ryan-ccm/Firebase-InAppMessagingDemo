# Firebase In-App Messaging Demo

## Introduction

This project is treated as MCV to reply email: `Case 00028356: In-App Messaging's triggerEvent() is not working [ ref:_00D1Ux0Jq._5001UPwF3t:ref ]`

## Change of project

In project code level, added `FirebaseInAppMessaging.getInstance().triggerEvent("view_sale")` on `KotlinMainActivity.kt` class.

## Expectation

Want to trigger an event (i.e. view_sale) `ONLY` when entering KotlinMainActivity.kt class. 

However, it can also be triggered on below cases: 
- app from background to re-foreground on any pages
- app launch