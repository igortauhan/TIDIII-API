require 'fileutils'

build = './mvnw clean package -DskipTests'
folders = Dir.entries('./backend/')

def run(command)
  `#{command}`
end

folders.each do |item|
  if item == '.idea' ||
     item == '.'     ||
     item == '..'
    next
  end

  run %(
    cd backend
  )
  run %(
    cd #{item}
  )
  run %(
    #{build}
  )
  run %(
    cd ../
  )
end
