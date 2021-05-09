import pygame
import constants
 
class Brick(pygame.sprite.Sprite):
    def __init__(self, width, height, numHits):
        super().__init__()

        self.numHits = numHits ## num hits 
        self.image = pygame.Surface([width, height])
        self.color = constants.BRICK_COLORS[self.numHits]

        self.width = width
        self.height = height

        pygame.draw.rect(self.image, self.color, [0, 0, self.width, self.height])
 
        self.rect = self.image.get_rect()