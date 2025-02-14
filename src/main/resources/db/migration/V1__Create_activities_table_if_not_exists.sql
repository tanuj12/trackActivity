CREATE TABLE IF NOT EXISTS activites {
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY, 
    task VARCHAR(255) NOT NULL,                    
    description TEXT,                          
    is_done BOOLEAN DEFAULT FALSE                    
}