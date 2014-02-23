CREATE TABLE public.wakai_word (
       wakai_id SERIAL NOT NULL
     , wakai_word VARCHAR(100) NOT NULL
     , PRIMARY KEY (wakai_id)
);

CREATE TABLE public.wakai_response (
       wakai_id SERIAL NOT NULL
     , wakai_word_response VARCHAR(256) NOT NULL
     , PRIMARY KEY (wakai_id)
);

CREATE TABLE public.wakai_null (
       wakai_id SERIAL NOT NULL
     , wakai_word_response VARCHAR(100) NOT NULL
     , PRIMARY KEY (wakai_id)
);

CREATE TABLE public.wakai_user (
       wakai_id SERIAL
     , wakai_login_name VARCHAR(16) NOT NULL
     , wakai_login_passwd VARCHAR(16) NOT NULL
     , wakai_role VARCHAR(16) NOT NULL
     , PRIMARY KEY (wakai_login_name)
);

