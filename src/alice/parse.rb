File.open('alice.txt','r') do |f|
  s = false
   f.each_char do |c| # iterate on each character
     if c =~ /[A-Za-z0-9]/
       putc c
       s = false
     else
       if s == false
         putc " "
         s = true
       end
     end
   end
end
