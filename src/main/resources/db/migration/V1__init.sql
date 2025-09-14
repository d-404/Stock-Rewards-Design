CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE rewards (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL,
  symbol TEXT NOT NULL,
  shares NUMERIC(18,6) NOT NULL,
  awarded_at TIMESTAMPTZ NOT NULL,
  price_per_share NUMERIC(18,4) NOT NULL,
  total_inr NUMERIC(18,4) NOT NULL,
  external_event_id TEXT UNIQUE NOT NULL,
  metadata JSONB,
  created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE holdings (
  user_id UUID NOT NULL,
  symbol TEXT NOT NULL,
  shares NUMERIC(18,6) NOT NULL DEFAULT 0,
  avg_cost_inr NUMERIC(18,4) DEFAULT 0,
  updated_at TIMESTAMPTZ DEFAULT now(),
  PRIMARY KEY (user_id, symbol)
);

CREATE TABLE prices (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  symbol TEXT NOT NULL,
  price_per_share NUMERIC(18,4) NOT NULL,
  source TEXT NOT NULL,
  fetched_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_prices_symbol ON prices(symbol);

CREATE TABLE daily_valuations (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL,
  date DATE NOT NULL,
  total_inr NUMERIC(18,4) NOT NULL,
  by_symbol JSONB NOT NULL,
  created_at TIMESTAMPTZ DEFAULT now(),
  UNIQUE (user_id, date)
);

CREATE TABLE ledger_entries (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID NOT NULL,
  account TEXT NOT NULL,
  amount_inr NUMERIC(18,4) NOT NULL,
  type TEXT NOT NULL,
  reference_id TEXT NOT NULL,
  created_at TIMESTAMPTZ DEFAULT now()
);
