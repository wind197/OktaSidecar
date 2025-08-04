# Okta Sidecar
This project serves as a skeleton for implementing Okta inline and event hooks. It also supports workflows like features such as custom API endpoints and scheduled tasks.

This is an extreme early version and many features have not been implemented yet.
## Event Hooks
Okta event hooks only allow for static authentication secrets, so we will use basic auth for securing these endpoints to avoid more complicated authentication schemes.

Okta also implements a verification request for the event hook, so you should always have both a GET for verification and POST for the actual events.

Okta documentation:
* [Okta Event Hooks Concepts](https://developer.okta.com/docs/concepts/event-hooks/)
* [Okta Event Hooks](https://help.okta.com/oie/en-us/content/topics/automation-hooks/event-hooks-main.htm)
## Inline Hooks
Inline hooks support both static auth and oauth, use the securityMatcher directive to include inline hooks in either the basic or oauth security filter.

Inline hooks must return a result within 3 seconds, so it is imperative for your code to complete quickly.

Okta documentation:
* [Okta Inline Hook Concepts](https://developer.okta.com/docs/concepts/inline-hooks/)
* [Okta Inline hooks](https://help.okta.com/oie/en-us/content/topics/automation-hooks/inline-hooks-main.htm)
## Scheduler
We are using [Quartz](https://www.quartz-scheduler.org/) for scheduling jobs in Sidecar. At this time the Okta Sidecar is only a loose skeleton, I would strongly recommend getting familiar with Quartz. It is simple to learn and jobs can be stored reliably in a DB and automatically restart after a loss in service.

We have a set of simple endpoints for managing jobs.
## Custom Endpoints
Of course you are also free to re-use configured services in the Sidecar to create custom endpoints with additional logic and constraints using either basic or oauth authentication.