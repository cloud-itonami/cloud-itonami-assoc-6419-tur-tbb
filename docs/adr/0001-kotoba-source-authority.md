# ADR 0001: Kotoba is the TBB catalog source authority

- Status: Accepted
- Date: 2026-07-21

`src/association_facts.kotoba` is the sole production source. It preserves the
complete 1958-10-08 founding date, the year-only 2007 arbitration-board date,
both absent revision dates, Turkish UTF-8 titles, official citations, and the
distinct governance and consumer-protection topics. Unknown associations,
aliases, fields, topics, and indexes fail closed; no effects are declared.

Conformance is observable semantics across the reference evaluator, restricted
JavaScript, and instantiated typed WebAssembly, including the typed ABI, bounds,
effects, and rejection behavior. Compiler-output byte identity is not a language
gate. Clojure and the JVM are compiler/test hosts only.
