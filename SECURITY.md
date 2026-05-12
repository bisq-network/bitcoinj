# Security Policy

  ## Supported Versions

  This repository is the Bisq-maintained fork of the `bitcoinj` library. It is
  used for Bitcoin protocol, wallet, transaction, key, script, SPV, peer-to-peer,
  and serialization functionality needed by Bisq.

  Security fixes are applied to the active Bisq-maintained branch and any active
  maintenance branches that Bisq still depends on.

  | Version / Branch | Supported |
  | --- | --- |
  | `main` | :white_check_mark: |
  | Active Bisq maintenance branches currently used by supported Bisq releases | :white_check_mark: |
  | Legacy Bisq branches no longer used by supported Bisq releases | :x: |
  | Old release tags, unsupported forks, or locally modified builds | :x: |

  Vulnerabilities in upstream `bitcoinj` should also be reported to the upstream
  `bitcoinj` project according to its own security policy. This policy covers the
  Bisq-maintained fork, including Bisq-specific changes, dependency updates, and
  integration behavior relevant to Bisq.

  ## Reporting a Vulnerability

  Please do **not** report security vulnerabilities through public GitHub issues,
  pull requests, Matrix rooms, forums, or social media.

  Report suspected vulnerabilities privately through GitHub's **Report a
  vulnerability** flow on this repository's Security page. If that option is not
  available, open a minimal public issue asking maintainers to enable a private
  security reporting channel, but do not include exploit details.

  Include as much detail as possible:

  - affected branch, commit, dependency, or release tag;
  - whether the issue also affects upstream `bitcoinj` or appears specific to the
    Bisq fork;
  - affected component, such as wallet, key management, deterministic seeds,
    transaction signing, script verification, SPV validation, block headers,
    peer-to-peer message parsing, bloom filters, payment channels, payment
    protocol, checkpoints, or serialization;
  - whether the issue can expose funds, private keys, wallet seeds, transaction
    privacy, peer identity, or chain-validation correctness;
  - reproduction steps, logs, malformed messages, transactions, blocks, wallet
    files, or proof of concept code where useful;
  - whether the issue depends on a malicious peer, malformed transaction/block,
    reorg, invalid SPV proof, compromised checkpoint data, unsafe randomness,
    dependency vulnerability, or unexpected wallet state.

  Bisq is an open-source project maintained by contributors. Response times may
  vary, but reports involving possible loss of funds, key or seed exposure,
  transaction-signing mistakes, incorrect validation of Bitcoin consensus or SPV
  data, or remotely triggerable crashes in peer/network parsing are treated as
  urgent security issues and will be triaged as quickly as possible.

  For lower-severity issues, maintainers will respond when contributor capacity is
  available.

  If the report is accepted, maintainers may coordinate a fix privately, prepare a
  patched branch or dependency update, notify upstream `bitcoinj` when appropriate,
  and publish an advisory after users have had a reasonable opportunity to update.
  If the report is declined, maintainers will explain the reason when possible.

  Please give maintainers reasonable time to investigate and release mitigations
  before public disclosure. For severe or actively exploited issues, coordinate
  timing with maintainers so public details do not increase risk to users.

  Bisq does not currently guarantee a bug bounty. Security work may be eligible
  for Bisq DAO compensation if it qualifies under the project's contributor and
  critical-bug processes.
