--    WandaPos - Touch Friendly Point Of Sale
--    Copyright (C) 2009-2014 uniCenta
--    http://www.unicenta.net
--
--    This file is part of WandaPos.
--
--    WandaPos is free software: you can redistribute it and/or modify
--    it under the terms of the GNU General Public License as published by
--    the Free Software Foundation, either version 3 of the License, or
--    (at your option) any later version.
--
--    WandaPos is distributed in the hope that it will be useful,
--    but WITHOUT ANY WARRANTY; without even the implied warranty of
--    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
--    GNU General Public License for more details.
--
--    You should have received a copy of the GNU General Public License
--    along with WandaPos.  If not, see <http://www.gnu.org/licenses/>.

-- Database upgrade script for PostgreSQL
-- v3.55 - v3.56

--
-- UPDATE existing tables
--

--
-- ALTER existing tables
--
ALTER TABLE CUSTOMERS ALTER COLUMN CURDEBT SET DEFAULT NULL;


-- UPDATE App' version
UPDATE APPLICATIONS SET NAME = $APP_NAME{}, VERSION = $APP_VERSION{} WHERE ID = $APP_ID{};

-- final script
DELETE FROM SHAREDTICKETS;
