library ieee;
use ieee.std_logic_1164.all;

entity Mux2N is
		generic (N: integer range 1 to 32 := 32);
	port (sel    : in  std_logic;
			input0 : in  std_logic_vector (N-1 downto 0);
			input1 : in  std_logic_vector (N-1 downto 0);
			muxout : out std_logic_vector (N-1 downto 0));
end Mux2N;

architecture Behavioral of Mux2N is
begin

	muxout<= input0 when (sel='0') else input1;
end Behavioral;