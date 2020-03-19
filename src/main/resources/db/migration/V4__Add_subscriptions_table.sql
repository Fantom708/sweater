create table user_subscriptions (
    channel_id int8 not null references usr,
    subsrider_id int8 not null references usr,
    primary key (channel_id, subsrider_id)
)
