-- Insert sample prices
INSERT INTO prices (id, symbol, price_per_share, source, fetched_at)
VALUES
  (gen_random_uuid(), 'TCS', 4200.50, 'demo', now()),
  (gen_random_uuid(), 'RELIANCE', 2500.75, 'demo', now()),
  (gen_random_uuid(), 'INFY', 1600.20, 'demo', now());

-- Insert a sample user holding
INSERT INTO holdings (user_id, symbol, shares, avg_cost_inr, updated_at)
VALUES
  ('11111111-1111-1111-1111-111111111111', 'TCS', 10.500000, 44105.25, now())
ON CONFLICT (user_id, symbol) DO NOTHING;

-- Insert sample rewards
INSERT INTO rewards (id, user_id, symbol, shares, awarded_at, price_per_share, total_inr, external_event_id, metadata, created_at)
VALUES
  (gen_random_uuid(), '11111111-1111-1111-1111-111111111111', 'TCS', 2.000000, now(), 4200.50, 8401.00, 'evt-001', '{"reason":"referral"}', now()),
  (gen_random_uuid(), '11111111-1111-1111-1111-111111111111', 'INFY', 1.500000, now(), 1600.20, 2400.30, 'evt-002', '{"reason":"signup_bonus"}', now())
ON CONFLICT DO NOTHING;

-- Insert a daily valuation for the sample user
INSERT INTO daily_valuations (id, user_id, date, total_inr, by_symbol, created_at)
VALUES
  (gen_random_uuid(), '11111111-1111-1111-1111-111111111111', current_date, 56506.55, '{"TCS":44105.25,"INFY":2400.30}', now())
ON CONFLICT (user_id, date) DO NOTHING;
