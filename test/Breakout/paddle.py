import pygame
import constants

class Paddle(pygame.sprite.Sprite):
    def __init__(self, color, width, height):
        super().__init__()
        
        self.speed = 10
        self.color = color
        self.width = width
        self.height = height

        self.image = pygame.Surface([width, height])
        self.image.fill(constants.COLOR_BLACK)
        self.image.set_colorkey(constants.COLOR_BLACK)

        pygame.draw.rect(self.image, color, [0, 0, width, height])
        self.rect = self.image.get_rect()
    
    def moveLeft(self):
        if(self.rect.left > 0):
            self.rect.x -= self.speed
    
    def moveRight(self):
        if(self.rect.right < constants.WIDTH):
            self.rect.x += self.speed